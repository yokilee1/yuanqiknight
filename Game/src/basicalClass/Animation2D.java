package basicalClass;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Animation2D {
	String animFile;		//动画文件
	public Image animImg;				//动画图片
	public int aw,ah;       	//宽，高
	public int col,row; 				//行列
	public int curDirection;    //当前方位֡

	
	public Animation2D(String animFile,int col,int row){	//构造函数
		this.animFile = animFile;
		this.col = col;
		this.row = row;
		
		animImg = new ImageIcon(getClass().getClassLoader().getResource("images/"+animFile)).getImage();		
		aw = animImg.getWidth(null)/col;
		ah = animImg.getHeight(null)/row;	
	}
	
	
}
