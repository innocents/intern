package net.dixq.irairabar;

import android.graphics.PointF;

public class DiagramCalcr {

	// center�𒆐S�Ɋp�xang�A���_�Qpt����]����
	public static void RotateDiagram(PointF pt[], final PointF center, final float ang) {
		for (int i = 0; i < pt.length; i++) {
			RotatePt(pt[i], center, ang);
		}
	}

	// rotaPt�𒆐S�Ɋp�xang�AorigPt����]����
	public static void RotatePt(PointF rotaPt, final PointF origPt, final float ang) {
		float cx = origPt.x;
		float cy = origPt.y;
		float x = rotaPt.x;
		float y = rotaPt.y;
		rotaPt.x = (float) (cx + Math.cos(ang) * (x - cx) - Math.sin(ang) * (y - cy));
		rotaPt.y = (float) (cy + Math.sin(ang) * (x - cx) + Math.cos(ang) * (y - cy));
	}

	// ���_�Qpt�̐�����cir���ڐG���Ă����炻�̐ڐG���Ă���x�N�g����ver�Ɋi�[����true��Ԃ�
	public static boolean isHit(PointF pt[], final Circle cir, Vec vec) {
		if (pt.length < 2) { // ���łȂ����
			return false;
		}
		int len = pt.length;
		for (int i = 1; i <= len; i++) {//�Ⴆ�ΐ���0-1,1-2,2-3,3-0�ƃ��[�v�����ĂȂ����%���g�p���ă��[�v
			Line line = new Line(pt[i - 1].x, pt[i - 1].y, pt[i % len].x, pt[i % len].y);
			if (isHitLC(line, cir) == true) {//�ڐG���Ă����
				vec._x= pt[i % len].x - pt[i - 1].x;//���̐����̃x�N�g�����i�[����
				vec._y= pt[i % len].y - pt[i - 1].y;
				return true;
			}
		}
		return false;
	}

	//����line�Ɖ~cir���������Ă����true��Ԃ�
	public static boolean isHitLC(Line L,Circle C){
		// �~�Ɛ����̓����蔻��֐�
		if((L._sx*(C._x-L._x) + L._sy*(C._y-L._y)) <= 0){
			// �n�_��ʂ餐����ɐ����Ȑ���u�����Ƃ���~�̒��S�������͈̔͊O�ɂ������Ƃ�
			// ������̎n�_����~�̒��S�܂ł̋����̂Q�棂Ƣ�~�̔��a�̂Q�棂Ƃ̔�r
			return (C._r*C._r >= (C._x-L._x)*(C._x-L._x)+(C._y-L._y)*(C._y-L._y));
		} else if(((-L._sx)*(C._x-(L._x+L._sx)) + (-L._sy)*(C._y-(L._y+L._sy))) <= 0){
			// �I�_��ʂ餐����ɐ����Ȑ���u�����Ƃ���~�̒��S�������͈̔͊O�ɂ������Ƃ�
			// ������̏I�_����~�̒��S�܂ł̋����̂Q�棂Ƣ�~�̔��a�̂Q�棂Ƃ̔�r
			return (C._r*C._r >= (C._x-(L._x+L._sx))*(C._x-(L._x+L._sx))+(C._y-(L._y+L._sy))*(C._y-(L._y+L._sy)));
		} else {
			// �����̎n�_�I�_�ɐ����������������Ƃ���~�̒��S�����͈͓̔��ɂ������Ƃ�
			float e = (float) Math.sqrt(L._sx*L._sx + L._sy*L._sy);   // �����x,y����������ΒP�x�N�g���ɂȂ�
			float c2 = (C._x-L._x)*(C._x-L._x)+(C._y-L._y)*(C._y-L._y);
			float b = (C._x-L._x)*(L._sx/e)+(C._y-L._y)*(L._sy/e);   // ���ςŎZ�o������וӂ̒���
			return (C._r*C._r >= c2 - b*b);
		}
	}
}
