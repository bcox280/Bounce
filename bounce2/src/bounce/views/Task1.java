package bounce.views;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import java.util.LinkedList;

import bounce.NestingShape;
import bounce.Shape;
import bounce.ShapeModel;

/*
* @author Blair Cox
*/
public class Task1 implements TreeModel {

	protected ShapeModel _model;
	protected LinkedList<TreeModelListener> _listenerList = new LinkedList<TreeModelListener>();

	public Task1(ShapeModel model) {

		_model = model;

	}

	@Override
	public void addTreeModelListener(TreeModelListener arg0) {

		_listenerList.add(arg0);

	}

	@Override
	public Object getChild(Object arg0, int arg1) {
		if (arg0 instanceof NestingShape) {

			try {
				return ((NestingShape) arg0).shapeAt(arg1);
			} catch (IndexOutOfBoundsException e) {

				return null;

			}

		}
		return null;
	}

	@Override
	public int getChildCount(Object arg0) {
		if (arg0 instanceof NestingShape) {

			return ((NestingShape) arg0).shapeCount();

		}
		return 0;
	}

	@Override
	public int getIndexOfChild(Object arg0, Object arg1) {
		if (arg0 instanceof NestingShape) {

			if (arg1 instanceof Shape) {
				return ((NestingShape) arg0).indexOf(((Shape) arg1));
			}
		}
		if (arg0 instanceof Shape) {

			return -1;

		}
		return 0;
	}

	@Override
	public Object getRoot() {

		return _model.root();

	}

	@Override
	public boolean isLeaf(Object arg0) {

		return !(arg0 instanceof NestingShape);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {

		_listenerList.remove(arg0);

	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {

	}

}
