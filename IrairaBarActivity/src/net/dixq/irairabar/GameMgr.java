package net.dixq.irairabar;

import java.util.ArrayList;
import java.util.LinkedList;

import net.dixq.irairabar.Barricade.eType;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GameMgr {
	
	private enum eStatus{
		NORMAL,
		GAMEOVER,
		GAMECLEAR,
		Bound
	};

	private static final float PI = (float) Math.PI;
	private ArrayList<Barricade> _barrList = new ArrayList<Barricade>();//障害物リスト
	private LinkedList<Task> _taskList = new LinkedList<Task>();// タスクリスト
	private eStatus _status = eStatus.NORMAL;
	private Player _player;

	GameMgr() {
		_barrList.add(new BarricadeSquare(  0,  0,480, 20, null));// 画面の4隅に四角を配置
		_barrList.add(new BarricadeSquare(  0,  0, 20,800, null));
		_barrList.add(new BarricadeSquare(460,  0, 20,800, null));
		_barrList.add(new BarricadeSquare(  0,780,480, 20, null));

		_barrList.add(new BarricadeTriangle(140, 200, 70, new BConf(-PI/270) ));
		_barrList.add(new BarricadeTriangle(140, 200, 70, new BConf(PI/270) ));// 三角
		_barrList.add(new BarricadeTriangle(350, 200, 70, new BConf(PI/270)));
		_barrList.add(new BarricadeTriangle(350, 200, 70, new BConf(-PI/270)));// 
		
		_barrList.add(new BarricadeTriangle(140, 200, 70, new BConf(-PI/360) ));
		_barrList.add(new BarricadeTriangle(140, 200, 70, new BConf(PI/360) ));// 三角
		_barrList.add(new BarricadeTriangle(350, 200, 70, new BConf(PI/360)));
		_barrList.add(new BarricadeTriangle(350, 200, 70, new BConf(-PI/360)));// 
		
		_barrList.add(new BarricadeTriangle(140, 200, 70, new BConf(-PI/540) ));
		_barrList.add(new BarricadeTriangle(140, 200, 70, new BConf(PI/540) ));// 三角
		_barrList.add(new BarricadeTriangle(350, 200, 70, new BConf(PI/540)));
		_barrList.add(new BarricadeTriangle(350, 200, 70, new BConf(-PI/540)));// 
		
		_barrList.add(new BarricadeTriangle(140, 200, 70, new BConf(-PI/720) ));
		_barrList.add(new BarricadeTriangle(140, 200, 70, new BConf(PI/720) ));// 三角
		_barrList.add(new BarricadeTriangle(350, 200, 70, new BConf(PI/720)));
		_barrList.add(new BarricadeTriangle(350, 200, 70, new BConf(-PI/720)));// 
		
		
		
		
		_barrList.add(new BarricadeTriangle2(140, 200, 70, new BConf(-PI/270) ));
		_barrList.add(new BarricadeTriangle2(140, 200, 70, new BConf(PI/270) ));// 三角
		_barrList.add(new BarricadeTriangle2(350, 200, 70, new BConf(PI/270)));
		_barrList.add(new BarricadeTriangle2(350, 200, 70, new BConf(-PI/270)));// 
		
		_barrList.add(new BarricadeTriangle2(140, 200, 70, new BConf(-PI/360) ));
		_barrList.add(new BarricadeTriangle2(140, 200, 70, new BConf(PI/360) ));// 三角
		_barrList.add(new BarricadeTriangle2(350, 200, 70, new BConf(PI/360)));
		_barrList.add(new BarricadeTriangle2(350, 200, 70, new BConf(-PI/360)));// 
		
		_barrList.add(new BarricadeTriangle2(140, 200, 70, new BConf(-PI/540) ));
		_barrList.add(new BarricadeTriangle2(140, 200, 70, new BConf(PI/540) ));// 三角
		_barrList.add(new BarricadeTriangle2(350, 200, 70, new BConf(PI/540)));
		_barrList.add(new BarricadeTriangle2(350, 200, 70, new BConf(-PI/540)));// 
		
		_barrList.add(new BarricadeTriangle2(140, 200, 70, new BConf(-PI/720) ));
		_barrList.add(new BarricadeTriangle2(140, 200, 70, new BConf(PI/720) ));// 三角
		_barrList.add(new BarricadeTriangle2(350, 200, 70, new BConf(PI/720)));
		_barrList.add(new BarricadeTriangle2(350, 200, 70, new BConf(-PI/720)));// 
		
		
		
		
		_barrList.add(new BarricadeTriangle(140, 600, 70, new BConf(-PI/270) ));
		_barrList.add(new BarricadeTriangle(140, 600, 70, new BConf(PI/270) ));// 三角
		_barrList.add(new BarricadeTriangle(350, 600, 70, new BConf(PI/270)));
		_barrList.add(new BarricadeTriangle(350, 600, 70, new BConf(-PI/270)));// 
		
		_barrList.add(new BarricadeTriangle(140, 600, 70, new BConf(-PI/360) ));
		_barrList.add(new BarricadeTriangle(140, 600, 70, new BConf(PI/360) ));// 三角
		_barrList.add(new BarricadeTriangle(350, 600, 70, new BConf(PI/360)));
		_barrList.add(new BarricadeTriangle(350, 600, 70, new BConf(-PI/360)));// 
		
		_barrList.add(new BarricadeTriangle(140, 600, 70, new BConf(-PI/540) ));
		_barrList.add(new BarricadeTriangle(140, 600, 70, new BConf(PI/540) ));// 三角
		_barrList.add(new BarricadeTriangle(350, 600, 70, new BConf(PI/540)));
		_barrList.add(new BarricadeTriangle(350, 600, 70, new BConf(-PI/540)));// 
		
		_barrList.add(new BarricadeTriangle(140, 600, 70, new BConf(-PI/720) ));
		_barrList.add(new BarricadeTriangle(140, 600, 70, new BConf(PI/720) ));// 三角
		_barrList.add(new BarricadeTriangle(350, 600, 70, new BConf(PI/720)));
		_barrList.add(new BarricadeTriangle(350, 600, 70, new BConf(-PI/720)));// 
		
	
		
		_barrList.add(new BarricadeTriangle2(140, 600, 70, new BConf(-PI/270) ));
		_barrList.add(new BarricadeTriangle2(140, 600, 70, new BConf(PI/270) ));// 三角
		_barrList.add(new BarricadeTriangle2(350, 600, 70, new BConf(PI/270)));
		_barrList.add(new BarricadeTriangle2(350, 600, 70, new BConf(-PI/270)));// 
		
		_barrList.add(new BarricadeTriangle2(140, 600, 70, new BConf(-PI/360) ));
		_barrList.add(new BarricadeTriangle2(140, 600, 70, new BConf(PI/360) ));// 三角
		_barrList.add(new BarricadeTriangle2(350, 600, 70, new BConf(PI/360)));
		_barrList.add(new BarricadeTriangle2(350, 600, 70, new BConf(-PI/360)));// 
		
		_barrList.add(new BarricadeTriangle2(140, 600, 70, new BConf(-PI/540) ));
		_barrList.add(new BarricadeTriangle2(140, 600, 70, new BConf(PI/540) ));// 三角
		_barrList.add(new BarricadeTriangle2(350, 600, 70, new BConf(PI/540)));
		_barrList.add(new BarricadeTriangle2(350, 600, 70, new BConf(-PI/540)));// 
		
		_barrList.add(new BarricadeTriangle2(140, 600, 70, new BConf(-PI/720) ));
		_barrList.add(new BarricadeTriangle2(140, 600, 70, new BConf(PI/720) ));// 三角
		_barrList.add(new BarricadeTriangle2(350, 600, 70, new BConf(PI/720)));
		_barrList.add(new BarricadeTriangle2(350, 600, 70, new BConf(-PI/720)));// 
		

		//_barrList.add(new BarricadeStar(120, 380, 20, 50,new BConf(eType.GOAL)));// 回転する星
		//_barrList.add(new BarricadeStar(400, 380, 20, 50,new BConf(eType.GOAL)));// 
		
		_barrList.add(new BarricadeSquare(250, 440, 150, 40,new BConf(PI/720)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, -150, -40,new BConf(PI/720)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, 40, 150,new BConf(PI/720)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, -40, -150,new BConf(PI/720)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, -40, 150,new BConf(PI/720)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, 40, -150,new BConf(PI/720)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, -150, 40,new BConf(PI/720)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, 150, -40,new BConf(PI/720)));//回転する四角
		
		_barrList.add(new BarricadeSquare(250, 440, 150, 40,new BConf(PI/540)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, -150, -40,new BConf(PI/540)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, 40, 150,new BConf(PI/540)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, -40, -150,new BConf(PI/540)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, -40, 150,new BConf(PI/540)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, 40, -150,new BConf(PI/540)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, -150, 40,new BConf(PI/540)));//回転する四角
		_barrList.add(new BarricadeSquare(250, 440, 150, -40,new BConf(PI/540)));//回転する四角
		
		_barrList.add(new BarricadeSquare2(250, 440, 150, 40,new BConf(-PI/360)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, -150, -40,new BConf(-PI/360)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, 40, 150,new BConf(-PI/360)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, -40, -150,new BConf(-PI/360)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, -40, 150,new BConf(-PI/360)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, 40, -150,new BConf(-PI/360)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, -150, 40,new BConf(-PI/360)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, 150, -40,new BConf(-PI/360)));//回転する四角
		
		_barrList.add(new BarricadeSquare2(250, 440, 150, 40,new BConf(-PI/630)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, -150, -40,new BConf(-PI/630)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, 40, 150,new BConf(-PI/630)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, -40, -150,new BConf(-PI/630)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, -40, 150,new BConf(-PI/630)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, 40, -150,new BConf(-PI/630)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, -150, 40,new BConf(-PI/630)));//回転する四角
		_barrList.add(new BarricadeSquare2(250, 440, 150, -40,new BConf(-PI/630)));//回転する四角
		
      

		_barrList.add(new BarricadeSquare(150, 750, 200, 50, new BConf(eType.GOAL)));//ゴール
		
		for (Barricade bar : _barrList) {
			_taskList.add(bar);	//タスクリストに障害物を追加
		}

		_player = new Player();
		_taskList.add(_player);
		_taskList.add(new FpsController());
	}

	private boolean Collision(){//衝突判定
		Vec vec = new Vec();
		final Circle cir = _player.getPt();//プレイヤーの中心円を取得
		for(Barricade barr : _barrList){//障害物の数だけループ
			Def.eHitCode code = barr.isHit(cir, vec);//接触判定
			switch(code){
			case OUT:
				_status = eStatus.GAMEOVER;//接触した物がアウトならゲームオーバー
				return true;
			case GOAL:
				_status = eStatus.GAMECLEAR;//接触した物がゴールならゲームクリア
				return true;
			
			}
		}
		return false;
	}
	
	
	
	public boolean onUpdate() {
		if( _status != eStatus.NORMAL ){
			return true;
		}
		if( Collision() ){
			return true;
		}
		for (int i = 0; i < _taskList.size(); i++) {
			if (_taskList.get(i).onUpdate() == false) { 
				_taskList.remove(i); 
				i--;
			}
		}
		return true;
	}

	private void drawStatus(Canvas c){
		switch( _status ){
		case GAMEOVER:
			{
				Paint paint = new Paint();
				paint.setTextSize(80);
				paint.setColor(Color.RED);
				c.drawText("え・・・？", 150, 400, paint);
			}
			break;
		case GAMECLEAR:
			{
		        Paint paint = new Paint();
				paint.setTextSize(120);
				paint.setColor(Color.GREEN);
				c.drawText("クリア！！", 80, 400, paint);
				
			}
			
		
		}
	}
	
	
	public void onDraw(Canvas c) {
		c.drawColor(Color.WHITE); // ���œh��Ԃ�
		for (Task task : _taskList) {
			task.onDraw(c);// �`��
		}
		drawStatus(c);
	}

}
