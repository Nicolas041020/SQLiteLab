package co.edu.unipiloto.starbuzz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {
    private List<Pet> petList;

    public PetAdapter(List<Pet> petList) {
        this.petList = petList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pet pet = petList.get(position);
        holder.nameTextView.setText(pet.getName());
        holder.descriptionTextView.setText("Descripcion: " + pet.getDescription());
        holder.ownerTextView.setText("Dueño: " + pet.getOwner());
    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, descriptionTextView, ownerTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textViewName);
            descriptionTextView = itemView.findViewById(R.id.textViewDescription);
            ownerTextView = itemView.findViewById(R.id.textViewOwner);
        }
    }
}
