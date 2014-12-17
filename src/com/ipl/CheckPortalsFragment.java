package com.ipl;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class CheckPortalsFragment extends android.support.v4.app.Fragment{

	View rootView;
	ExpandableListView lv;
	private ArrayList<Group> groups;
	//private String[][][] children;

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    groups = new ArrayList<Group>();
	    
	    Group temp;
	    
	    temp = new Group("Test 1");
	    temp.getChildren().add("10/10/10 20:00:00");
	    temp.getChildren().add("5");
	    temp.getChildren().add("11/11/11 20:00:00");
	    temp.getChildren().add("6");
	    groups.add(temp);
	    
	    temp = new Group("Test 2");
	    temp.getChildren().add("20/20/20 20:00:00");
	    temp.getChildren().add("10");
	    temp.getChildren().add("22/22/22 20:00:00");
	    temp.getChildren().add("11");
	    groups.add(temp);
	    
	    temp = new Group("Test 3");
	    temp.getChildren().add("30/30/30 20:00:00");
	    temp.getChildren().add("15");
	    temp.getChildren().add("33/33/33 20:00:00");
	    temp.getChildren().add("16");
	    groups.add(temp);
	    
	    //groups = new String[] { "Test Header 1", "Test Header 2", "Test Header 3", "Test Header 4" };
	    
	    /*children = new Group []; {
	        {  },
	        { "b" },
	        { "c" },
	        { "d" }
	    };*/
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    rootView = inflater.inflate(R.layout.fragment_check, container, false);  

	return rootView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
	    super.onViewCreated(view, savedInstanceState);

	    lv = (ExpandableListView) view.findViewById(R.id.listView);
	    lv.setAdapter(new ExpandableListAdapter(groups));
	    lv.setGroupIndicator(null);

	}

	public class ExpandableListAdapter extends BaseExpandableListAdapter {

	    private final LayoutInflater inf;
	    private ArrayList<Group> groups;
	    //private String[][] children;

	    public ExpandableListAdapter(ArrayList<Group> groups) {
	    	
	        this.groups = groups;
	        inf = LayoutInflater.from(getActivity());
	    }

	    @Override
	    public int getGroupCount() {
	        return groups.size();
	    }

	    @Override
	    public int getChildrenCount(int groupPosition) {
	        return 1;//groups.get(groupPosition).getChildren().size();
	    }

	    @Override
	    public Object getGroup(int groupPosition) {
	        return groups.get(groupPosition).getGroup();
	    }

	    @Override
	    public Object getChild(int groupPosition, int childPosition) {
	        return groups.get(groupPosition).getChildren().get(childPosition);
	    }

	    @Override
	    public long getGroupId(int groupPosition) {
	        return groupPosition;
	    }

	    @Override
	    public long getChildId(int groupPosition, int childPosition) {
	        return childPosition;
	    }

	    @Override
	    public boolean hasStableIds() {
	        return true;
	    }

	    @Override
	    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

	            convertView = inf.inflate(R.layout.listrow_details3, parent, false);
	            
	            TextView date = (TextView) convertView.findViewById(R.id.date);
	            TextView time = (TextView) convertView.findViewById(R.id.time);
	            TextView recharge = (TextView) convertView.findViewById(R.id.recharge);
	            TextView decay = (TextView) convertView.findViewById(R.id.decayed);

	            date.setText(getChild(groupPosition, 0).toString());
	            time.setText(getChild(groupPosition, 1).toString());
	            recharge.setText(getChild(groupPosition, 2).toString());
	            decay.setText(getChild(groupPosition, 3).toString());

	            return convertView;
	    }

	    @Override
	    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
	        convertView = inf.inflate(R.layout.listrow_group, parent, false);

	        TextView text = (TextView) convertView.findViewById(R.id.textView1);
	        text.setText(getGroup(groupPosition).toString());

	        return convertView;
	    }

	    @Override
	    public boolean isChildSelectable(int groupPosition, int childPosition) {
	        return true;
	    }

	    private class ViewHolder {
	        TextView text;
	    }
	}
}