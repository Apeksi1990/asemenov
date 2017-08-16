package ru.asemenov.models;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private int id;
    private String name;
    private String login;
    private String address;
    private String roleId;
    private List<MusicType> musicType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<MusicType> getMusicType() {
        return musicType;
    }

    public void setMusicType(List<MusicType> musicType) {
        this.musicType = musicType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (roleId != null ? !roleId.equals(user.roleId) : user.roleId != null) return false;
        return musicType != null ? musicType.equals(user.musicType) : user.musicType == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (musicType != null ? musicType.hashCode() : 0);
        return result;
    }
}
