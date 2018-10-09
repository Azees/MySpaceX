package com.space.myspacex.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.space.myspacex.Activity.AppUtils;
import com.space.myspacex.R;
import com.space.myspacex.model.Links;
import com.space.myspacex.model.MasterJson;
import com.space.myspacex.model.OrbitParams;
import com.space.myspacex.model.Payload;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class PayloadDetails extends Fragment {
    private Spinner list_orbit_params;
    private ArrayList<Payload> payloadDetails;
    private TextView txtPayloadId;
    private TextView txtNoradId;
    private TextView txtReused;
    private TextView txtCustomers;
    private TextView txtNationality;
    private TextView txtManufacturer;
    private TextView txtPayloadType;
    private TextView txtPayloadMassKg;
    private TextView txtPayloadmass_lbs;
    private TextView txtOrbit;
    private  List<String> orbitparms;
   private OrbitParams orbitParams;
    ArrayList<OrbitParams> orbitParams_list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_payload_details, container, false);
        txtPayloadId = view.findViewById(R.id.txt_payload_id);
        txtNoradId = view.findViewById(R.id.txt_norad_id);
        txtReused = view.findViewById(R.id.txt_reused);
        txtCustomers = view.findViewById(R.id.txt_customers);
        txtNationality = view.findViewById(R.id.txt_nationality);
        txtManufacturer = view.findViewById(R.id.txt_manufacturer);
        txtPayloadType = view.findViewById(R.id.txt_payload_type);
        txtPayloadMassKg = view.findViewById(R.id.txt_payload_mass_kg);
        txtPayloadmass_lbs = view.findViewById(R.id.txt_payload_mass_lbs);
        txtOrbit = view.findViewById(R.id.txt_orbit);
        list_orbit_params = view.findViewById(R.id.list_orbit_params);
        Bundle bundle = getArguments();
        if (bundle != null) {
            MasterJson masterJson = (MasterJson) bundle.getParcelable(AppUtils.DETAILS);
            payloadDetails = (ArrayList<Payload>) masterJson.getRocket().getSecondStage().getPayloads();
        }
        if (payloadDetails != null) {
            for(int i=0;i<payloadDetails.size();i++){
                txtPayloadId.setText("PayloadId : " + payloadDetails.get(i).getPayloadId());
                txtNoradId.setText("NoradId : " + payloadDetails.get(i).getNoradId());
                Log.d(" NoradId"," NoradId"+payloadDetails.get(i).getNoradId());
                txtReused.setText("Reused : " + payloadDetails.get(i).getReused());
                txtCustomers.setText("Customers : " + payloadDetails.get(i).getCustomers());
                txtNationality.setText("Nationality : " + payloadDetails.get(i).getNationality());
                txtManufacturer.setText("Manufacturer : " + payloadDetails.get(i).getManufacturer());
                txtPayloadType.setText("PayloadType : " + payloadDetails.get(i).getPayloadType());
                txtPayloadMassKg.setText("PayloadMassKg : " + payloadDetails.get(i).getPayloadMassKg());
                txtPayloadmass_lbs.setText("PayloadMassLbs : " + payloadDetails.get(i).getPayloadMassLbs());
                txtOrbit.setText("Orbit : " + payloadDetails.get(i).getOrbit());
                OrbitParams orbitParams = payloadDetails.get(i).getOrbitParams();
                orbitParams_list = new ArrayList<OrbitParams>();
                orbitParams_list.add(orbitParams);
                String reference_system = orbitParams.getReferenceSystem();
                String regime = orbitParams.getRegime() ;
                String longitude = String.valueOf(orbitParams.getLongitude());
                String semi_major_axis_km = String.valueOf(orbitParams.getSemiMajorAxisKm());
                String eccentricity = orbitParams.getEpoch();
                String periapsis_km = String.valueOf(orbitParams.getPeriapsisKm());
                String apoapsis_km = String.valueOf(orbitParams.getApoapsisKm());
                String inclination_deg = String.valueOf(orbitParams.getInclinationDeg());
                String period_min = String.valueOf(orbitParams.getPeriodMin());
                String lifespan_years = String.valueOf(orbitParams.getLifespanYears());
                String epoch = orbitParams.getEpoch();
                String mean_motion = String.valueOf(orbitParams.getMeanMotion());
                String raan = String.valueOf(orbitParams.getRaan());
                String arg_of_pericenter = String.valueOf(orbitParams.getArgOfPericenter());
                String mean_anomaly = String.valueOf(orbitParams.getMeanAnomaly());
               orbitparms= new ArrayList<>();
               // orbitParams_list=new ArrayList<OrbitParams>();
                orbitparms.add(reference_system);
                orbitparms.add(regime);
                orbitparms.add(longitude);
                orbitparms.add(semi_major_axis_km);
                orbitparms.add(eccentricity);
                orbitparms.add(periapsis_km);
                orbitparms.add(apoapsis_km);
                orbitparms.add(inclination_deg);
                orbitparms.add(period_min);
                orbitparms.add(lifespan_years);
                orbitparms.add(epoch);
                orbitparms.add(mean_motion);
                orbitparms.add(raan);
                orbitparms.add(arg_of_pericenter);
                orbitparms.add(mean_anomaly);
                Log.d("spinner data","spinner data"+orbitparms);

                }
        ArrayAdapter<String> spinnerArrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,orbitparms);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            list_orbit_params.setAdapter(spinnerArrayAdapter);
        }
        return view;
    }

}
