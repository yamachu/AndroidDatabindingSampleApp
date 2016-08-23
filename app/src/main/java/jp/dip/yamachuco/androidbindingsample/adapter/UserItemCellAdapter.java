package jp.dip.yamachuco.androidbindingsample.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jp.dip.yamachuco.androidbindingsample.model.User;
import jp.dip.yamachuco.androidbindingsample.R;
import jp.dip.yamachuco.androidbindingsample.databinding.UserListItemCellBinding;

/**
 * Created by yamachu on 2016/08/24.
 */
public class UserItemCellAdapter extends RecyclerView.Adapter<UserItemCellAdapter.ViewHolder> {
    private List<User> userList;

    public UserItemCellAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return UserItemCellType.fromId(viewType).createViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = userList.get(position);
        UserItemCellType.fromId(getItemViewType(position)).bindViewHolder(holder, user);
    }

    @Override
    public int getItemViewType(int position) {
        return UserItemCellType.ITEM.getId();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    enum UserItemCellType {
        HEADER(0) {
            @Override
            public void bindViewHolder(ViewHolder holder, User user) {

            }

            @Override
            public ViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent) {
                return null;
            }
        },
        ITEM(1) {
            @Override
            public void bindViewHolder(ViewHolder holder, User user) {
                ((UserItemCellItemViewHolder) holder).getBinding().setUser(user);
            }

            @Override
            public ViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent) {
                View view = inflater.inflate(R.layout.user_list_item_cell, parent, false);
                return new UserItemCellItemViewHolder(view);
            }
        },
        FOOTER(2) {
            @Override
            public void bindViewHolder(ViewHolder holder, User user) {

            }

            @Override
            public ViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent) {
                return null;
            }
        };

        private final int id;

        private UserItemCellType(final int id) {
            this.id = id;
        }

        static public UserItemCellType fromId(final int id) {
            for (UserItemCellType viewType : values()) {
                if (viewType.getId() == id) {
                    return viewType;
                }
            }
            throw new AssertionError("no view type enum found for the id. you forgot to implement?");
        }

        public int getId() {
            return id;
        }

        public abstract void bindViewHolder(ViewHolder holder, User user);

        public abstract ViewHolder createViewHolder(LayoutInflater inflater, ViewGroup parent);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class UserItemCellItemViewHolder extends ViewHolder {
        private UserListItemCellBinding binding;

        public UserItemCellItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public UserListItemCellBinding getBinding() {
            return binding;
        }
    }

    public static class UserItemCellHeaderViewHolder extends ViewHolder {
        private UserListItemCellBinding binding;

        public UserItemCellHeaderViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public UserListItemCellBinding getBinding() {
            return binding;
        }
    }

    public static class UserItemCellFooterViewHolder extends ViewHolder {
        private UserListItemCellBinding binding;

        public UserItemCellFooterViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public UserListItemCellBinding getBinding() {
            return binding;
        }
    }
}
