package com.example.arpad.fragmentdemo;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {
    OnFragmentInteractionListener mCallback;

    public interface OnFragmentInteractionListener {
        public void setValue( String value );
    }

    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_simple, container, false);
        View rootView = inflater.inflate(R.layout.fragment_simple, container, false);

        final EditText etValue = (EditText) rootView.findViewById(R.id.etValue);

        Button btnToMainFragment = (Button) rootView.findViewById(R.id.btnToMainFragment);
        btnToMainFragment.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = etValue.getText().toString();
                mCallback.setValue( message );

                ((MainActivity) getActivity()).showMainFragment();
            }
        });

        Button btnToBlankFragment = (Button) rootView.findViewById(R.id.btnToBlankFragment);
        btnToBlankFragment.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).showBlankFragment();
            }
        });



        return rootView;
    }
}
