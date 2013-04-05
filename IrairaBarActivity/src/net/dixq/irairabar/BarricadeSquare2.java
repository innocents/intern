package net.dixq.irairabar;


public class BarricadeSquare2 extends Barricade { //四角形

	public BarricadeSquare2( float x, float y, float w, float h, BConf conf ){
		super(4,conf);
		_pt[0].x  = x;		_pt[0].y = y;
		_pt[1].x  = x+w;	_pt[1].y = y;
		_pt[2].x  = x+w;	_pt[2].y = y+h;
		_pt[3].x  = x;		_pt[3].y = y+h;
		_center.x = x+w;
		_center.y = y+h;
	}
	
		 
}
