import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;
import synthesizer.GuitarString;

public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final int totalNotes = 37;

    private static double ithConcert(int i) {
        return CONCERT_A * Math.pow(2, (i - 24) / 12);
    }

    public static void main(String[] args) {
        // Create an instance of the GuitarString class
        synthesizer.GuitarString[] gs = new synthesizer.GuitarString[totalNotes];
        for (int i = 0; i < totalNotes; i++) {
            gs[i] = new GuitarString(ithConcert(i));
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index < 0) {
                    System.out.println("please enter valid key: " + keyboard);
                    continue;
                }
                gs[index].pluck();
            }

            double sample = 0;
            for (synthesizer.GuitarString string : gs) {
                sample += string.sample();
            }
            StdAudio.play(sample);
            for (synthesizer.GuitarString string : gs) {
                string.tic();
            }
        }
    }
}

