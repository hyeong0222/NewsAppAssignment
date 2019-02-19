package com.example.newsappassignment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlineFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    OnHeadlineSelectedListener mCallback;

    public interface OnHeadlineSelectedListener {
        void onArticleSelected (int position, String item);
    }

    public HeadlineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (OnHeadlineSelectedListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_headline, container, false);
        listView = view.findViewById(R.id.listViewCountries);
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getContext(), (CharSequence) parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();

        String itemClicked = (String) parent.getItemAtPosition(position);
        mCallback.onArticleSelected(position, itemClicked);

    }
}
