package bounce.forms;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.swing.SwingWorker;
import bounce.ImageRectangleShape;
import bounce.NestingShape;
import bounce.ShapeModel;
import bounce.forms.util.Form;
import bounce.forms.util.FormHandler;

/*
* @author Blair Cox
*/
public class ImageShapeFormHandler implements FormHandler 
{

	 int _deltaX;
	int _deltaY;
	protected ShapeModel _model;
	protected NestingShape _parentOfNewShape;
	

	public ImageShapeFormHandler(ShapeModel model, NestingShape parent) 
	{
		
		_model = model;
		_parentOfNewShape = parent;
		
	}

	protected void createImageShape(BufferedImage fixedImage)
	{

		ImageRectangleShape imageShape = new ImageRectangleShape(_deltaX, _deltaY, fixedImage);
		_model.add(imageShape, _parentOfNewShape);

	}
	
	@Override
	public void processForm(Form form)
	{

		
		
		class Processor extends SwingWorker<BufferedImage, Void>
		{

			Form _form;
			ImageShapeFormHandler _shapeHandler;

			Processor(ImageShapeFormHandler shapeHandler, Form form){

				_form = form;
				_shapeHandler = shapeHandler;
			}

			@Override
			protected BufferedImage doInBackground() throws Exception{

				long startTime = System.currentTimeMillis();

				// Read field values from the form.
				File imageFile = (File) form.getFieldValue(File.class, ImageFormElement.IMAGE);
				int width = _form.getFieldValue(Integer.class, ShapeFormElement.WIDTH);
				_deltaX = form.getFieldValue(Integer.class, ShapeFormElement.DELTA_X);
				_deltaY = form.getFieldValue(Integer.class, ShapeFormElement.DELTA_Y);

				// Load the original image (ImageIO.read() is a blocking call).
				BufferedImage fullImage = null;
				try{
					fullImage = ImageIO.read(imageFile);
				} catch (IOException e) {
					System.out.println("Error loading image.");
				}

				int fullImageWidth = fullImage.getWidth();
				int fullImageHeight = fullImage.getHeight();

				BufferedImage scaledImage = fullImage;

				// Scale the image if necessary.
				if (fullImageWidth > width){
					double scaleFactor = (double) width / (double) fullImageWidth;
					int height = (int) ((double) fullImageHeight * scaleFactor);

					scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
					Graphics2D g = scaledImage.createGraphics();

					// Method drawImage() scales an already loaded image. The
					// ImageObserver argument is null because we don't need to
					// monitor
					// the scaling operation.
					g.drawImage(fullImage, 0, 0, width, height, null);

					// Create the new Shape and add it to the model.

				}

				long elapsedTime = System.currentTimeMillis() - startTime;

				System.out.println("Image loading ans scaling took " + elapsedTime + "ms.");

				return scaledImage;
			}

			@Override
			protected void done() 
			{
				
				try {

					_shapeHandler.createImageShape(get());
					

				} catch (ExecutionException ee) 
				{
					
					// Do nothing
					ee.printStackTrace();
					return;
					

				} catch (InterruptedException ei)
				{

					// Do nothing
					ei.printStackTrace();
					return;

				}
				
				return;

			}
			
		}

		Processor process = new Processor(this, form);
		process.execute(); // Template Method

	}

	

}
