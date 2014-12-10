package grammarChecker;

import grammarChecker.Dictionary.Bucket.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {

	private int M = 1319;
    final private Bucket[] array;
    public Dictionary() {
        array = new Bucket[M];
        for (int i = 0; i < M; i++) {
            array[i] = new Bucket();
        }
    }

    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(String key) {
        array[hash(key)].put(key);
    }

    public boolean contains(String input) {
        input = input.toLowerCase();
        return array[hash(input)].get(input);
    }

    public void build(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                add(line);
            }
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public String[] getRandomEntries(int num){
        String[] toRet = new String[num];
        for (int i = 0; i < num; i++){
            Node n = array[(int)Math.random()*M].first;
            int rand = (int)Math.random()*(int)Math.sqrt(num);

            for(int j = 0; j<rand && n.next!= null; j++) n = n.next;
            toRet[i]=n.word;


        }
        return toRet;
    }

    class Bucket {

        private Node first;

        public boolean get(String in) {       
            Node next = first;
            while (next != null) {
                if (next.word.equals(in)) {
                    return true;
                }
                next = next.next;
            }
            return false;
        }

        public void put(String key) {
            for (Node curr = first; curr != null; curr = curr.next) {
                if (key.equals(curr.word)) {
                    return;                     
                }
            }
            first = new Node(key, first); 
        }

        class Node {

            String word;
            Node next;

            public Node(String key, Node next) {
                this.word = key;
                this.next = next;
            }

        }

    }
}
