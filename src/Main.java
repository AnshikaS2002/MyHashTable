public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my hash tables");

        String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        MyHashTable<String, Integer> myHashTable = new MyHashTable<>();

        String[] words = sentence.toLowerCase().split("\\s+");

        for (String word : words) {
            Integer frequency = myHashTable.get(word);
            if (frequency == null) {
                myHashTable.add(word, 1);
            } else {
                myHashTable.add(word, frequency + 1);
            }
        }

        System.out.println("Word Frequencies:");
        for (String word : myHashTable.keys()) {
            System.out.println(word + ": " + myHashTable.get(word));
        }
    }
}
