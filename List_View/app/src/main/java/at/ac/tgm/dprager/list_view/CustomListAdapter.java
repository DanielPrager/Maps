package at.ac.tgm.dprager.list_view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomListAdapter  extends BaseAdapter {

    private List<Cocktail> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<Cocktail> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.imageView_Cocktail = (ImageView) convertView.findViewById(R.id.imageView_Cocktail);
            holder.textView_Name = (TextView) convertView.findViewById(R.id.textView_Name);
            holder.textView_Aufwand = (TextView) convertView.findViewById(R.id.textView_Aufwand);
            holder.textView_Zutaten = (TextView) convertView.findViewById(R.id.textView_Zutaten);
            holder.textView_Zutaten.setTypeface(null, Typeface.BOLD);
            holder.textView_anz = (TextView) convertView.findViewById(R.id.textView_anz);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Cocktail cocktail = this.listData.get(position);
        holder.textView_Name.setText(cocktail.getCocktailName());
        holder.textView_Aufwand.setText("Aufwand: " + cocktail.getAufwand()+" Minuten");
        holder.textView_Zutaten.setText("Zutaten: ");
        if(cocktail.getZutaten()>1) {
            holder.textView_anz.setText(cocktail.getZutaten() + " Produkte");
        } else {
            holder.textView_anz.setText(cocktail.getZutaten() + " Produkt");
        }

        int imageId = this.getMipmapResIdByName(cocktail.getCocktail_image());

        holder.imageView_Cocktail.setImageResource(imageId);

        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView imageView_Cocktail;
        TextView textView_Name;
        TextView textView_Aufwand;
        TextView textView_Zutaten;
        TextView textView_anz;

    }

}
