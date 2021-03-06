package com.example.list_it;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MostrarDatosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MostrarDatosFragment extends Fragment {
    RecyclerView recyclerViewListas;
    ListasAdapter lAdapter;
    FirebaseFirestore mfirestore;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MostrarDatosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MostrarDatosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MostrarDatosFragment newInstance(String param1, String param2) {
        MostrarDatosFragment fragment = new MostrarDatosFragment();
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
        View view = inflater.inflate(R.layout.fragment_mostrar_datos, container, false);
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_mostrar_datos, container, false);
        recyclerViewListas = (RecyclerView) view.findViewById(R.id.RecyclerView);
        recyclerViewListas.setLayoutManager(new LinearLayoutManager(getActivity()));
        mfirestore = FirebaseFirestore.getInstance();
   //     CollectionReference query = mfirestore.collection("Listas");
        Query query = mfirestore.collection("Listas");
        FirestoreRecyclerOptions<Listas>FireStoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Listas>().setQuery(query, Listas.class).build();
        lAdapter = new ListasAdapter(FireStoreRecyclerOptions);
        lAdapter.notifyDataSetChanged();
        recyclerViewListas.setAdapter(lAdapter);

        return view;



        }
    @Override
    public void onStart(){
        super.onStart();
        lAdapter.startListening();
    }

    @Override
    public void onStop(){
        super.onStop();
        lAdapter.stopListening();
    }
    }
