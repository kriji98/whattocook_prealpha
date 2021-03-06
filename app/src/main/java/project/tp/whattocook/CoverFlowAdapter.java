package project.tp.whattocook;

/**
 * Created by kristiana on 12.05.16.
 */

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

public class CoverFlowAdapter extends BaseAdapter {

    private ArrayList<PopularRecipe> data;
    private AppCompatActivity activity;

    public CoverFlowAdapter(AppCompatActivity context, ArrayList<PopularRecipe> objects) {
        this.activity = context;
        this.data = objects;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public PopularRecipe getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_flow_view, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.PopularRecipeImage.setImageResource(data.get(position).getImageSource());
        viewHolder.PopularRecipeName.setText(data.get(position).getName());

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.dialog_popularrecipe_info);
                dialog.setCancelable(true); // dimiss when touching outside
                dialog.setTitle(getItem(position).getName());

                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(getItem(position).getImageSource());
                TextView ingredients = (TextView) dialog.findViewById(R.id.ingredients);
                ingredients.setText("Съставки: " + getItem(position).getIngredients());
                TextView time = (TextView) dialog.findViewById(R.id.recipes_time);
                time.setText("Време: " + getItem(position).getTime() + " минути");
                TextView preparation = (TextView) dialog.findViewById(R.id.preparation);
                preparation.setText("Приготвяне: " + getItem(position).getPreparation());

                dialog.show();
            }
        };
    }


    private static class ViewHolder {
        private TextView PopularRecipeName;
        private ImageView PopularRecipeImage;

        public ViewHolder(View v) {
            PopularRecipeImage = (ImageView) v.findViewById(R.id.image);
            PopularRecipeName = (TextView) v.findViewById(R.id.name);
        }
    }
}