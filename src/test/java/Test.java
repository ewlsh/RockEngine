import com.sci.engine.SciGame;
import com.sci.engine.graphics.Display;
import com.sci.engine.graphics.JFrameDisplay;
import com.sci.engine.graphics.Renderer;
import com.sci.engine.gui.GUI;
import com.sci.engine.gui.components.Button;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class Test extends SciGame
{
	private GUI gui = new GUI()
	{
		@Override
		public void render(int x, int y, Renderer renderer)
		{
			super.render(x, y, renderer);
		}
	};

	public Test(Display display)
	{
		super(display);
	}

	@Override
	public void init()
	{
		this.gui.add(new Button(10, 10, 160, 40));
	}

	@Override
	public void update()
	{
		this.gui.update();
	}

	@Override
	public void render(Renderer renderer)
	{
		this.gui.render(0, 0, renderer);
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