package bounce.views;

import javax.swing.event.TreeModelEvent;

import bounce.ShapeModelListener;
import bounce.ShapeModel;
import bounce.ShapeModelEvent;

/*
* @author Blair Cox
*/
public class Task2 extends Task1 implements ShapeModelListener{

	public Task2(ShapeModel model){

		super(model);

	}

	@Override
	public void update(ShapeModelEvent event){

		if (event.eventType().equals(ShapeModelEvent.EventType.ShapeAdded) )
		{
			//unpack
			// model where fire happened
			Object location = event.source();
			// path to where the add event occurred
			Object[] pathToEvent = event.parent().path().toArray();
			// returns the shape that got fired
			Object[] child = { event.operand() };

			// returns the index of the shape that got fired
			int[] childIndex = { event.index() };
			//repack
			TreeModelEvent treeEvent = (new TreeModelEvent(location, pathToEvent, childIndex, child));
			for (int i = 0; i < _listenerList.size(); i++) {

				// Update the listeners
				_listenerList.get(i).treeNodesInserted(treeEvent);
			}			

			// check if the event was of type ShapeModelEvent and was removed
		} 
		else if (event.eventType().equals(ShapeModelEvent.EventType.ShapeRemoved))
		{
			//unpack
			// model where event happened
			Object location = event.source();
			// path to where the remove event occurred
			Object[] pathToEvent = event.parent().path().toArray();

			// returns the shape that got fired
			Object[] child = { event.operand() };
			// returns the index of the shape that got fired
			int[] childIndex = { event.index() };
			//repack
			TreeModelEvent treeEvent = (new TreeModelEvent(location, pathToEvent, childIndex, child));
			for (int i = 0; i < _listenerList.size(); i++) {

				// Update the listeners
				_listenerList.get(i).treeNodesRemoved(treeEvent);
			}
			
		}

		// check if the event was of type ShapeModelEvent and was added}

	}
	


	

}
