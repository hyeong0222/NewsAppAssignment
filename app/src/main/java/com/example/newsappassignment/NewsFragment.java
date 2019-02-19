package com.example.newsappassignment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    protected static final String ARG_POSITION = "position";
    TextView textView;
    String news;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        textView = view.findViewById(R.id.textViewNews);

        Bundle bundle = getArguments();
        if (bundle != null) {
            news = bundle.getString(ARG_POSITION);
            textView.setText(news);
        }

        return view;
    }

    public void updateArticleView (String item) {
        textView.setText(item);
    }

}
