package com.insufficientlight.CollegeAppBilly;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.backendless.Backendless;
//import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;

import java.util.ArrayList;
import java.util.List;


public class FamilyListFragment extends ListFragment
{
    final private String TAG = "FAMILYLISTFRAGMENT";
    private Family mFamily;

    public FamilyListFragment()
    {
        mFamily = Family.getFamily();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.family_memeber_title);
        FamilyMemberAdapter adapter = new FamilyMemberAdapter(mFamily.getFamilyList());
        setListAdapter(adapter);
        mFamily = Family.getFamily();
    }

    private class FamilyMemberAdapter extends ArrayAdapter<FamilyMember>
    {
        public FamilyMemberAdapter(ArrayList<FamilyMember> family)
        {
            super(getActivity(), 0, family);

        }
        @Override
        public View getView ( int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_family_member, null);
                FamilyMember f = getItem(position);
                TextView nameTextView =
                        (TextView) convertView
                                .findViewById(R.id.family_member_list_item_nameTextView);
                nameTextView.setText(f.getFirstName() + " " + f.getLastName());
                return convertView;

            }
            else
            {
                return null;
            }
        }
    }
}