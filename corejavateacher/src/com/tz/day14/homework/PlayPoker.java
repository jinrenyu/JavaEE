package com.tz.day14.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayPoker
{

	public void play(int person, int cards)
	{
		// 得到新扑克
		List<Card> poker = Poker.newPoker();
		//
		if(poker.size() < person * cards) {
			throw new RuntimeException("你指定的人数和人均数量之积超过了牌的总数.");
		}
		
		// 洗牌
		Collections.shuffle(poker);
		//发牌
		for(int i=0;i<person;i++) {
			//发牌的方法
			List<Card> my = getIt(poker, cards);
			//输出
			System.out.printf("第【%d】位玩家的牌:\n",i+1);
			for(Card c : my) {
				System.out.printf("%s ",c);
			}
			System.out.println(); //换行
		}
	}

	private List<Card> getIt(List<Card> poker, int cards)
	{
		List<Card> myCards = null;
		//判断
		int realCard = cards;
		if(poker.size() < cards) {
			realCard = poker.size();
		}
		//填充
		List<Card> temp = poker.subList(0, realCard);
		//
		myCards = new ArrayList<>(temp);
		//把发出去的牌清空
		temp.clear();
		
		//返回
		return myCards;
	}
}


