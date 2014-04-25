package com.sci.engine.graphics;

import com.sci.engine.interfaces.Rotatable;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * SciEngine: RockEngine Fork
 *
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RotatableTexture extends Texture implements Rotatable {

    private BufferedImage image;

    /**
     * Creates a new texture with the specified width, height, and pixels.
     * Called by static factory
     *
     * @param width
     * @param height
     * @param pixels
     */
    RotatableTexture(int width, int height, int[] pixels, BufferedImage image) {
        super(width, height, pixels);
        this.image = image;
    }

    /**
     * Renders a rotated version of this texture at x and y (in pixels)
     *
     * @param {@link Renderer}
     * @param x (in pixels)
     * @param y (in pixels)
     * @param rotX (in pixels)
     * @param rotY (in pixels)
     * @param angle (in degrees)
     */
    @Override
    public void rotatedRender(Renderer renderer, int x, int y, int rotX, int rotY, int angle) {
        if (angle == 0) {
            renderer.setPixels(x, y, getWidth(), getHeight(), getPixels());
            return;
        }
        double radians = Math.toRadians(angle);
        AffineTransform transform = AffineTransform.getRotateInstance(radians, rotX, rotY);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage image = op.filter(this.image, null);
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
        renderer.setPixels(x, y, image.getWidth(), image.getHeight(), pixels);
    }

    /**
     * Loads a texture from an InputStream
     *
     * @param {@link InputStream}
     * @return the loaded {@link Texture} or null
     */
    public static RotatableTexture load(InputStream in) {
        try {
            BufferedImage image = ImageIO.read(in);
            int width = image.getWidth();
            int height = image.getHeight();
            int[] pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
            return new RotatableTexture(width, height, pixels, image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads a texture from a BufferedImage
     *
     * @param {@link BufferedImage}
     * @return the loaded {@link Texture} or null
     */
    public static RotatableTexture load(BufferedImage in) {
        try {
            BufferedImage image = in;
            int width = image.getWidth();
            int height = image.getHeight();
            int[] pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
            return new RotatableTexture(width, height, pixels, image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
