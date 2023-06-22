package edu.birzeit.dictionary;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.birzeit.dictionary.model.Word;

public class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{
    private Context context;
    private List<Word> Words;


    public CaptionedImagesAdapter(Context context, List<Word> Words){
        this.context = context;
        this.Words = Words;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_word,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Word w = Words.get(position);
        CardView myCardView = holder.cardView;
        TextView title = (TextView)myCardView.findViewById(R.id.title);
        TextView meaning = (TextView)myCardView.findViewById(R.id.meaning);
        TextView definition = (TextView)myCardView.findViewById(R.id.definition);
        title.setText(w.getTitle());
        meaning.setText(w.getMeaning());
        definition.setText(w.getDefinition());
        myCardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Dialog myDialog = new Dialog(context);
                myDialog.setContentView(R.layout.card);
                TextView t1 = myDialog.findViewById(R.id.txtName);
                TextView t2 = myDialog.findViewById(R.id.txtName2);
                TextView t3 = myDialog.findViewById(R.id.txtName3);
                t1.setText(w.getTitle());
                t2.setText(w.getMeaning());
                t3.setText(w.getDefinition());
                myDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Words.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}

