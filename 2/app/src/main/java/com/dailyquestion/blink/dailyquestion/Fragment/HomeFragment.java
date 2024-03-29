package com.dailyquestion.blink.dailyquestion.Fragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.dailyquestion.blink.dailyquestion.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment{



    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }


    }

    public List<String[]> getList(){
        List<String[]> res = new ArrayList<String[]>();
        for(int i = 0; i < 3; i++){
            String input[] = new String[2];
            input[0] = String.valueOf(i * 2 + 1);
            input[1] = String.valueOf(i * 2 + 2);
            res.add(input);
        }
        return res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        if(view != null) {
            ListView listView = (ListView) view.findViewById(R.id.listView_levels);
            listLvlAdapter lvlAdapter = new listLvlAdapter(getList());
            listView.setAdapter(lvlAdapter);
            listView.setDivider(null);
        }
        else {
            System.out.println("#################Get view is null");
        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }


    class listLvlAdapter extends BaseAdapter {

        List<String[]> butText;

        listLvlAdapter(List<String[]> burText) {
            super();
            this.butText = burText;
        }

        @Override
        public int getCount() {
            return butText.size();
        }

        @Override
        public Object getItem(int position) {
            if(position >= getCount())
                return null;
            return this.butText.get(position);
        }

        @Override
        public long getItemId(int position) {
            if(position >= getCount())
                return 0;
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(position >= getCount())
                return null;
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) getActivity().getApplication()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.home_list_item, parent,false);
            }
            final Button leftButton = (Button) convertView.findViewById(R.id.butt_left);
            final Button rightButton = (Button) convertView.findViewById(R.id.butt_right);

            leftButton.setText(this.butText.get(position)[0]);
            leftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*System.out.println("#######Report " + leftButton.getText() + " clicked");*/

                    Fragment fragment = new LevelFragment().newInstance(String.valueOf(leftButton.getText()));
                    FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();

                    fragmentTransaction.replace(R.id.frame_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
            });
            rightButton.setText(this.butText.get(position)[1]);
            rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*System.out.println("#######Report " + rightButton.getText() + " clicked");*/

                    Fragment fragment = new LevelFragment().newInstance(String.valueOf(rightButton.getText()));
                    FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();

                    fragmentTransaction.replace(R.id.frame_container, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
            return convertView;
        }
    }

}
