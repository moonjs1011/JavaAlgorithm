package swea.month04.week03.day0424.problem13072;

import java.util.*;
class Soilder{
	int mTeam;
	int mScore;
	public Soilder(int mTeam,int mScore) {
		this.mTeam = mTeam;
		this.mScore = mScore;
	}
	public void setMScore(int mScore) {
		this.mScore = mScore;
	}
}
class UserSolution
{
	static Map<Integer,Soilder> m;
	public void init()
	{ 
		m = new HashMap<>();
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		m.put(mID,new Soilder(mTeam,mScore));
	}
	
	public void fire(int mID)
	{
		m.remove(mID);
	}

	public void updateSoldier(int mID, int mScore)
	{
		Soilder existSoilder = m.get(mID);
		existSoilder.setMScore(mScore);
		m.put(mID, existSoilder);
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		Soilder existSoilder = m.get
	}
	
	public int bestSoldier(int mTeam)
	{
		return 0;
	}
}