import com.sci.engine.SciGame;
import com.sci.engine.graphics.Display;
import com.sci.engine.graphics.JFrameDisplay;
import com.sci.engine.graphics.Renderer;
import com.sci.engine.graphics.Texture;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class Test extends SciGame
{
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
		System.out.println(this.getFPS());
	}

	@Override
	public void render(Renderer renderer)
	{
		renderer.render(10, 10, this.testTexture);
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