import java.awt.event.KeyEvent;
import com.sci.engine.SciGame;
import com.sci.engine.graphics.Color;
import com.sci.engine.graphics.Display;
import com.sci.engine.graphics.JFrameDisplay;
import com.sci.engine.graphics.Renderer;
import com.sci.engine.graphics.Texture;
import com.sci.engine.input.Keyboard;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class Test extends SciGame
{
	private int x = 25;
	private int y = 25;
	private Texture testTexture;

	public Test(Display display)
	{
		super(display);
	}

	@Override
	public void init()
	{
		this.testTexture = Texture.load(Test.class.getResourceAsStream("test.png"));
	}

	@Override
	public void update()
	{
		if(Keyboard.isKeyDown(KeyEvent.VK_W))
			this.y--;
		else if(Keyboard.isKeyDown(KeyEvent.VK_S))
			this.y++;

		if(Keyboard.isKeyDown(KeyEvent.VK_A))
			this.x--;
		else if(Keyboard.isKeyDown(KeyEvent.VK_D))
			this.x++;
	}

	@Override
	public void render(Renderer renderer)
	{
		System.out.println(this.getFPS());
		
		renderer.render(this.x, this.y, this.testTexture);
		renderer.fillRect(100, 50, 10, 10, Color.RED);
	}

	@Override
	public void shutdown()
	{

	}

	public static void main(String[] args)
	{
		new Test(new JFrameDisplay("Test", 800, 600)).start();
	}
}