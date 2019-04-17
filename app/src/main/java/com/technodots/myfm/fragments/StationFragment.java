package com.technodots.myfm.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.technodots.myfm.R;
import com.technodots.myfm.adapters.StationAdapter;
import com.technodots.myfm.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_STATION_TYPE = "station_type";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static final int STATION_TYPE_FEATURED=0;
    public static final int STATION_TYPE_RECENT=1;
    public static final int STATION_TYPE_PARTY=2;

    private int stationType;


    private OnFragmentInteractionListener mListener;

    public StationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType The Radio Stations Type.

     * @return A new instance of fragment StationFragment.
     */

    public static StationFragment newInstance(int stationType) {
        StationFragment fragment = new StationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE,stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType=getArguments().getInt(ARG_STATION_TYPE);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =inflater.inflate(R.layout.fragment_station, container, false);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycler_station);
        recyclerView.setHasFixedSize(true);

        StationAdapter adapter ;

        if (stationType==STATION_TYPE_FEATURED){
            adapter=new StationAdapter(DataService.getInstance().getFeaturedStations());


        } else if (stationType==STATION_TYPE_RECENT){

            adapter=new StationAdapter(DataService.getInstance().getRecentStations());
        }else
        {
         adapter=new StationAdapter(DataService.getInstance().getRecentStations());

        }

        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        return  v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }

        //Showing error for else
        /* else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    }

