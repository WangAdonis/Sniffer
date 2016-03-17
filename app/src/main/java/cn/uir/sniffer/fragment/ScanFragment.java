package cn.uir.sniffer.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import cn.uir.sniffer.R;
import cn.uir.sniffer.item.ScanItem;


import java.util.List;


public class ScanFragment extends ListFragment {


    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private ListAdapter mAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ScanFragment() {
    }

    // TODO: Customize parameter initialization
//    @SuppressWarnings("unused")
//    public static ScanFragment newInstance(int columnCount) {
//        ScanFragment fragment = new ScanFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_COLUMN_COUNT, columnCount);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        mAdapter=new ListAdapter();
        setListAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        for (int i=0;i<10;i++){
            mAdapter.add(new ScanItem());
        }


        return view;
    }


    private class ListAdapter extends ArrayAdapter<ScanItem> {

        public ListAdapter(){
            super(getActivity(),0);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView=getActivity().getLayoutInflater().inflate(R.layout.list_item_scan,null);
            }
            return convertView;
        }
    }



}
