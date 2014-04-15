import java.io.FileInputStream;
import java.io.IOException;
import com.sci.engine.SciGame;
import com.sci.engine.graphics.Color;
import com.sci.engine.graphics.Display;
import com.sci.engine.graphics.Font;
import com.sci.engine.graphics.Font.CharCase;
import com.sci.engine.graphics.JFrameDisplay;
import com.sci.engine.graphics.Renderer;
import com.sci.engine.graphics.Texture;
import com.sci.engine.gui.Component;
import com.sci.engine.gui.GUI;
import com.sci.engine.gui.components.Button;
import com.sci.engine.gui.listeners.ClickListener;

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
		Button testButton = new Button(10, 10, 160, 40);
		this.gui.add(testButton);
		testButton.addListener(new ClickListener()
		{
			@Override
			public void onClicked(Component component)
			{
				System.out.println("click");
			}
		});
	}

	@Override
	public void update()
	{
		this.gui.update();
	}

	@Override
	public void render(Renderer renderer)
	{
		if(renderer.getFont() == null)
		{
			try
			{
				int width = 16;
				int height = 16;
				char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ    0123456789-.?/%$\\=*+,;:()&#\"'".toCharArray();
				Texture texture = Texture.load(new FileInputStream("src/main/resources/font.png"));
				Font font = new Font(width, height, characters, texture);
				font.setCharCase(CharCase.UPPER);
				renderer.setFont(font);
			}
			catch(Throwable t)
			{
				t.printStackTrace();
			}
		}

		renderer.drawString(100, 100, "SWAGMASTER420BLAZINIT");
		this.gui.render(0, 0, renderer);

		renderer.fillRect(200, 200, 75, 75, new Color(255, 0, 0, 100));
		renderer.fillRect(225, 225, 25, 25, new Color(0, 0, 255, 255));
	}

	@Override
	public void shutdown()
	{

	}

	public static void main(String[] args) throws IOException
	{
		new Test(new JFrameDisplay("Test", 800, 600)).start();
	}
}