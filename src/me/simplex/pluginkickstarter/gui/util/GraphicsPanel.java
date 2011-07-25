package me.simplex.pluginkickstarter.gui.util;

import javax.swing.JPanel;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.awt.TexturePaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class GraphicsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MediaTracker tracker = new MediaTracker(this);
	private BufferedImage texture;
	private boolean singlePaint;

	public GraphicsPanel(boolean sp, String file) {
		singlePaint = sp;
		texture = loadTexture(file);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (texture == null) {
			g2.drawString("", 0, 0);
			return;
		}
		if (singlePaint) {
			g2.drawImage(texture, null, 0, 0);
		} else {
			Rectangle r = new Rectangle(0, 0, texture.getWidth(), texture.getHeight());
			TexturePaint paint = new TexturePaint(texture, r);
			Dimension dim = getSize();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.setPaint(paint);
			g2.fillRect(0, 0, dim.width, dim.height);
		}
	}

	private BufferedImage loadTexture(String location) {
		Image image = null;
		BufferedImage bufferedImage = null;
		URL url = this.getClass().getResource(location);
		if (url == null)
			return null;

		image = Toolkit.getDefaultToolkit().getImage(url);
		if (image != null) {
			tracker.addImage(image, 0);
			try {
				tracker.waitForAll();
			} catch (InterruptedException e) {
				tracker.removeImage(image);
				image = null;
			} finally {

				if (image != null)
					tracker.removeImage(image);

				if (tracker.isErrorAny())
					image = null;

				if (image != null) {
					if (image.getWidth(null) < 0 || image.getHeight(null) < 0)
						image = null;
				}
			}
		}

		if (image != null) {
			bufferedImage = new BufferedImage(image.getWidth(null), image
					.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, null);
			g.dispose();
		}
		return bufferedImage;
	}
	
	public void changeBackground(String file){
		texture = loadTexture(file);
		repaint();
	}
}