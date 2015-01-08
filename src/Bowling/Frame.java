package Bowling;

public class Frame {
	private int frameScore;
	private Character firstTrie;
	private Character secondTrie;
	private Character firstBonus;
	private Character secondBonus;
	
	public Frame() {
		this.frameScore = 0;
		this.firstTrie = null;
		this.secondTrie = null;
		this.firstBonus = null;
		this.secondBonus = null;
	}
	
	public Character getFirstTrie(){
		return this.firstTrie;
	}
	public Character getSecondTrie(){
		return this.secondTrie;
	}
	
	public void addPointsToFrameStrike(Character trie) {
		if (trie.equals('X')){
			this.firstTrie = trie;
			this.frameScore +=10;
			//se tiene que devolver 2 frames mas para tener el resultado final
		}
	}
	
	public void addPointsToFrame(Character trie1, Character trie2) {
		if (trie2.equals('/')){
			this.firstTrie = trie1;
			this.secondTrie = trie2;
			this.frameScore +=10; 
			//se tiene que devolver 1 frames mas para tener el resultado final
		}else{
			this.firstTrie = trie1;
			this.secondTrie = trie2;
			if (Character.isDigit(trie1)) {
				this.frameScore += Integer.parseInt(trie1.toString());
			}
			if (Character.isDigit(trie2)) {
				this.frameScore += Integer.parseInt(trie2.toString());
			}
		}
	}
	
	public void addBonusPointsToFrame(Character bonus){
		if(this.firstBonus != null){
			this.firstBonus = bonus;
		}else if(this.secondBonus != null){
			this.secondBonus = bonus;
		}
		
	}
	
	public int getFirstBonus(){
		if(this.firstBonus != null){
			if (this.firstBonus.equals('X')) {
				return 10;
			} else if (Character.isDigit(this.firstBonus)) {
				return Integer.parseInt(firstBonus.toString());
			}
			
		}
		return 0;
	}
	
	public int getSecondBonus(){
		if(this.secondBonus != null){
			if (this.secondBonus.equals('X')) {
				return 10;
			} else if (Character.isDigit(this.secondBonus)) {
				return Integer.parseInt(this.secondBonus.toString());
			}
		}
		return 0;
	}
	
	public boolean isStrike(){
		if (this.firstTrie.equals('X')) {
			return true;
		}
		return false;
	}
	
	public boolean isSpare(){
		if (this.secondTrie.equals('/') && this.secondTrie != null) {
			return true;
		}
		return false;
	}
	
	public int getActualFrameScore(){
		return this.frameScore;
	}
	
}