package Bowling;

import java.util.ArrayList;
import java.util.List;


public class Bowling {
	
	/*private int checkItem(String trie){
		if (trie.equals("X")) {
			return 10;
		}else if (trie.equals("/")) {
			return 10;
		}else if (trie.equals("-")) {
			return 0;
		}else return Integer.parseInt(trie);
	}
	
     public int score(String roll){
    	String[] sol = roll.split("");
    	int sum=0;
    	for(int i = 0;i<roll.length();i++){
    		sum +=checkItem(sol[i]);
    	}
    	return sum;
   
     }*/
	
	public final int MAX_FRAMES = 10;

	public  List<Frame> readFrame(String roll){
		List<Frame> listFrames = new ArrayList<Frame>();
	   	for (int i = 0; i < roll.length(); i++) {
	   		if (listFrames.size() == MAX_FRAMES){
	   			System.out.println("hola");
	   		} else{
		   		Frame frame = new Frame();
		   		Character trie = roll.charAt(i);
				 if (trie.equals('X')){ 
					frame.addPointsToFrameStrike(trie);
					//System.out.println("Trie1: "+frame.getFirstTrie()+" Trie2: "+frame.getSecondTrie()+" Score: "+frame.getActualFrameScore());
	
				 }else{
					 Character trie2 = roll.charAt(i+1);
					 frame.addPointsToFrame(trie, trie2);
					 //System.out.println("Trie1: "+frame.getFirstTrie()+" Trie2: "+frame.getSecondTrie()+" Score: "+frame.getActualFrameScore());
					 i+=1;
				 }
				 //System.out.println(i);
				 listFrames.add(frame);
			}
	   	}
	   	return listFrames;
    }
	
	public int calculateScore (String roll){
		List<Frame> frames = readFrame(roll);
		int[] arrayPendingToSum = new int[10];
		 
		for(int i = 0;i<frames.size();i++){
			if (frames.get(i).isStrike()) {
				arrayPendingToSum[i] = 2;
			} else if (frames.get(i).isSpare()) {
				arrayPendingToSum[i] = 1;
			} else arrayPendingToSum[i] = 0;
			
			//System.out.println("Score: "+frames.get(i).getActualFrameScore());
			//System.out.println("Pending: "+arrayPendingToSum[i]);
		}
		 
		int totalScore = 0;
		for (int i = 0; i < arrayPendingToSum.length; i++) {
			 totalScore += frames.get(i).getActualFrameScore();
			 if (i < arrayPendingToSum.length) {
				 if (arrayPendingToSum[i] == 2){ //Strike sumo los dos siguientes
					 totalScore += frames.get(i+1).getActualFrameScore();
					 totalScore += frames.get(i+2).getActualFrameScore();
				 } else if (arrayPendingToSum[i] == 1){ //Spare sumo el siguientes
					 totalScore += frames.get(i+1).getActualFrameScore();
				 }
			}
		}
		return totalScore;
	}
    
}
