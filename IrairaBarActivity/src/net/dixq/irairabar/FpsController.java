package net.dixq.irairabar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class FpsController extends Task {

	private long _startTime = 0;				//����J�n����
	private int  _cnt = 0;						//�J�E���^
	private Paint _paint = new Paint();			//paint���
	private float _fps;							//fps
	private final static int N = 60;			//���ς����T���v����
	private final static int FONT_SIZE = 20;	//�t�H���g�T�C�Y
	
	public FpsController(){
		_paint.setColor(Color.BLUE);	//�t�H���g�̐F��ɐݒ�
		_paint.setTextSize(FONT_SIZE);	//�t�H���g�T�C�Y��ݒ�
	}
	
	@Override
	public boolean onUpdate(){
		if( _cnt == 0 ){							//1�t���[���ڂȂ玞�����L��
			_startTime = System.currentTimeMillis();
		}
		if( _cnt == N ){							//60�t���[���ڂȂ畽�ς��v�Z����
			long t = System.currentTimeMillis();
			_fps = 1000.f/((t-_startTime)/(float)N);
			_cnt = 0;
			_startTime = t;
		}
		_cnt++;
		return true;
	}

	@Override
	public void onDraw(Canvas c){
		c.drawText(String.format("%.1f", _fps), 0, FONT_SIZE-2, _paint);
	}

}
