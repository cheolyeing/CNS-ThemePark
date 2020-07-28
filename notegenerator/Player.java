package notegenerator;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Player {

    private SourceDataLine line = null;

    private Notes notes = new Notes();

    private long time = 250;

    private double volumen = 1;

    public void play(String keys) {

        byte[] data = parse(keys);

        start();

        line.write(data, 0, data.length);

        stop();

    }

    public void play(String... track) {

        byte[] data2 = parseAll(track);

        if (data2 != null) {
            start();

            line.write(data2, 0, data2.length);

            stop();
        }

    }

    private byte[] parseAll(String... track) {

        byte[] data2 = null;

        for (String t : track) {
            byte[] data1 = parse(t);
            if (data2 == null) {
                data2 = data1;
            } else {
                data2 = notes.addWaves(data1, data2);
            }
        }

        return data2;

    }

    private byte[] parse(String song) {
        time = 250;

        volumen = 1;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        String[] key = song.split(" ");

        byte[] data = null;

        for (String k : key) {
            int mult = 1;

            if (k.indexOf("*") > -1) {
                String keyAux = k.split("\\*")[0];
                mult = Integer.parseInt(k.split("\\*")[1]);
                k = keyAux;
            } else if (k.startsWith("T")) {
                time = Long.parseLong(k.substring(1));
                continue;
            } else if (k.startsWith("V")) {
                volumen =  Double.parseDouble(k.substring(1)) / 100;

                if(volumen>1) volumen = 1;
                if(volumen<0) volumen = 0;

                continue;
            }

            if (k.indexOf("-") > -1) {
                k = k.replaceAll("-", " ").trim();
                data = notes.getCordData(k, time * mult);
            } else {
                data = notes.tone(k, time * mult);
            }

            volumen(data);

            try {
                baos.write(data);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return baos.toByteArray();

    }



    private void volumen(byte[] data) {
        for(int i=0; i<data.length; i++){
            data[i] = (byte) (data[i] * volumen);
        }

    }

    private void stop() {
        line.drain();
        line.stop();

    }

    private void start() {

        AudioFormat format = new AudioFormat(8000.0F, 8, 1, true, false);

        SourceDataLine.Info info = new DataLine.Info(SourceDataLine.class,
                format); // format
        // is
        // an
        // AudioFormat
        // object
        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("Format not supported");
            System.exit(1);
        }

        // Obtain and open the line.
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }

        // Assume that the TargetDataLine, line, has already
        // been obtained and opened.
        int numBytesRead;

        line.start();

    }

    public void save(String track, String fname) throws IOException {
        byte[] data = parse(track);

        FileOutputStream fos = new FileOutputStream(fname);

        fos.write(data);
        fos.flush();
        fos.close();

    }

}