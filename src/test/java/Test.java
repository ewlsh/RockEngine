import com.sci.engine.SciGame;
import com.sci.engine.graphics.Display;
import com.sci.engine.graphics.JFrameDisplay;
import com.sci.engine.graphics.Renderer;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class Test extends SciGame
{
	public Test(Display display)
	{
		super(display);
	}

	@Override
	public void init()
	{

	}

	@Override
	public void update()
	{
		System.out.println(this.getFPS());
	}

	@Override
	public void render(Renderer renderer)
	{

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