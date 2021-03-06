package util.RSS;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import upv.welcomeincoming.app.R;

public class RssListAdapter extends ArrayAdapter<Message> {
    private Context _context;
    private List<Message> messages;

    public RssListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        _context = context;
    }

    public RssListAdapter(Context context, int resource, List<Message> items) {
        super(context, resource, items);
        messages = items;
    }
    @Override
    public int getCount(){
        return messages.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.row, null);

        }

        Message p = getItem(position);

        if (p != null) {
            TextView title = (TextView) v.findViewById(R.id.textTitle);

            if (title != null) {
                title.setTypeface(null, Typeface.BOLD);
                title.setText(p.getTitle());
               // title.setTypeface(Typeface.createFromAsset(_context.getAssets(), "fonts/futura_font.ttf"));
            }
        }

        return v;

    }

}