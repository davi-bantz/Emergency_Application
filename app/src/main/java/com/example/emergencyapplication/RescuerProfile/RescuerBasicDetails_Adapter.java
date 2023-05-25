package com.example.emergencyapplication.RescuerProfile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emergencyapplication.R;
import com.example.emergencyapplication.Rescuer_Registration.DBHelper;
import com.example.emergencyapplication.Rescuer_Registration.ReadWriteUserDetails;

import java.util.List;

public class RescuerBasicDetails_Adapter extends RecyclerView.Adapter<RescuerBasicDetails_Adapter.ViewHolder> {

    List<ReadWriteUserDetails> rescuer;
    Context context;
    DBHelper dbHelper;

    public RescuerBasicDetails_Adapter(List<ReadWriteUserDetails> rescuer, Context context) {
        this.rescuer = rescuer;
        this.context = context;
        dbHelper = new DBHelper(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rescuerlist, parent, false);
        ViewHolder viewHolder =  new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ReadWriteUserDetails readWriteUserDetails = rescuer.get(position);

        holder.name.setText(readWriteUserDetails.getName());
        holder.email.setText(readWriteUserDetails.getEmail());
        holder.phone.setText(readWriteUserDetails.getPhone());
        holder.Dob.setText(readWriteUserDetails.getDob());


    }

    @Override
    public int getItemCount() {
        return rescuer.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        EditText name;
        EditText email;
        EditText phone;
        EditText Dob;
        Button buttonUpdate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.editUser_Name);
            email = itemView.findViewById(R.id.editUserName1);
            phone = itemView.findViewById(R.id.editdob);
            Dob = itemView.findViewById(R.id.editRescuerPhoneNumber);
            buttonUpdate = itemView.findViewById(R.id.Rescuer_EditBTN);

        }

    }
}
