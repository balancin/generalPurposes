package br.com.balancin.stream.impl;

import br.com.balancin.stream.Stream;

public class StreamImpl implements Stream {

	private String word;
    private int counter;

    public StreamImpl(String word) {
        this.word = word;
        counter = 0;
    }

    @Override
    public char getNext() {
        if(hasNext()){
            return word.charAt(counter++);
        }

        return word.charAt(word.length() - 1);
    }

    @Override
    public boolean hasNext() {
        return (counter < word.length());
    }

}
