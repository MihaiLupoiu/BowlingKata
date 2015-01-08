package Bowling;

import java.util.ArrayList;
import java.util.List;


public class Bowling {
	
	public final int MAX_FRAMES = 10;

	public  List<Frame> readFrame(String roll){
		List<Frame> listFrames = new ArrayList<Frame>();
	   	for (int i = 0; i < roll.length(); i++) {
	   		Character trie = roll.charAt(i);
	   		if (listFrames.size() == MAX_FRAMES){
	   			listFrames.get(listFrames.size()-1).addBonusPointsToFrame(trie);
	   		} else{
		   		Frame frame = new Frame();
				 if (trie.equals('X')){ 
					frame.addPointsToFrameStrike(trie);
	
				 }else{
					 Character trie2 = roll.charAt(i+1);
					 frame.addPointsToFrame(trie, trie2);
					 i+=1;
				 }
				 listFrames.add(frame);
			}
	   	}
	   	return listFrames;
    }
	
	public int calculateScore (String roll){
		List<Frame> frames = readFrame(roll);
		int totalScore = 0;
		for (int i = 0; i < frames.size(); i++) {
			Frame actualFrame = frames.get(i);
			totalScore += actualFrame.getTemporalFrameScore();
			if (actualFrame.isStrike()){
				if (i+1 >= frames.size()) {
						totalScore += frames.get(frames.size()-1).getFirstBonus();
						totalScore += frames.get(frames.size()-1).getSecondBonus();
				 }else if (i+2 >= frames.size()) { // caso exepcional
					 	totalScore += frames.get(i+1).getFrameFirstTrie();
						totalScore += frames.get(frames.size()-1).getFirstBonus();
				 }else{
					 if (frames.get(i+1).isStrike()) {
						 totalScore += frames.get(i+1).getFrameFirstTrie();
						 totalScore += frames.get(i+2).getFrameFirstTrie();
					}else{
						totalScore += frames.get(i+1).getFrameFirstTrie();
						totalScore += frames.get(i+1).getFrameSecondTrie();
					}	
				 }
			} else if (actualFrame.isSpare()){
				if (i+1 >= frames.size()) {
					totalScore += frames.get(frames.size()-1).getFirstBonus();
				}else{ 
					 totalScore += frames.get(i+1).getFrameFirstTrie();
				 }
			}
		}
		return totalScore;
	}

    
}
