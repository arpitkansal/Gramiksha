package com.android.gramiksha.gramiksha;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactUsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactUsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ContactUsFragment() {
        // Required empty public constructor
    }
TextView email_bhopal,main_email,email_jaipur,email_indore,email_gwal,email_delhi,email_lxm;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactUsFragment newInstance(String param1, String param2) {
        ContactUsFragment fragment = new ContactUsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view= inflater.inflate(R.layout.fragment_contact_us, container, false);
        
        main_email=(TextView) view.findViewById(R.id.main_email);
        email_bhopal=(TextView) view.findViewById(R.id.email_bhopal);
        email_jaipur=(TextView) view.findViewById(R.id.email_jaipur);
        email_delhi=(TextView) view.findViewById(R.id.email_delhi);
        email_indore=(TextView) view.findViewById(R.id.email_indore);
        email_gwal=(TextView) view.findViewById(R.id.email_gwal);
        email_lxm=(TextView) view.findViewById(R.id.email_lxm);

        main_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("plain/test");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"connect@gramiksha.in"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK/QUERIES");
                intent.putExtra(Intent.EXTRA_TEXT, "Your feedback and queries here...!!");
                startActivity(intent);
            }
        });

        email_bhopal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("plain/test");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"bhopal@gramiksha.in"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK/QUERIES: Bhopal Gramiksha");
                intent.putExtra(Intent.EXTRA_TEXT, "Your feedback and queries here...!!");
                startActivity(intent);
            }
        });

        email_indore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("plain/test");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"indore@gramiksha.in"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK/QUERIES: Indore Gramiksha");
                intent.putExtra(Intent.EXTRA_TEXT, "Your feedback and queries here...!!");
                startActivity(intent);
            }
        });

        email_delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("plain/test");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"delhi@gramiksha.in"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK/QUERIES: Delhi Gramiksha");
                intent.putExtra(Intent.EXTRA_TEXT, "Your feedback and queries here...!!");
                startActivity(intent);
            }
        });

        email_gwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("plain/test");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"gwalior@gramiksha.in"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK/QUERIES: Gwalior Gramiksha");
                intent.putExtra(Intent.EXTRA_TEXT, "Your feedback and queries here...!!");
                startActivity(intent);
            }
        });

        email_lxm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("plain/test");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"lxm@gramiksha.in"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK/QUERIES: Laxmangarh Gramiksha");
                intent.putExtra(Intent.EXTRA_TEXT, "Your feedback and queries here...!!");
                startActivity(intent);
            }
        });

        email_jaipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("plain/test");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jaipur@gramiksha.in"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK/QUERIES: Jaipur Gramiksha");
                intent.putExtra(Intent.EXTRA_TEXT, "Your feedback and queries here...!!");
                startActivity(intent);
            }
        });
     return view;    
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
        } else {
            throw new RuntimeException(context.toString()
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
