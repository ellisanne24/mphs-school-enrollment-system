/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.user.User;

/**
 *
 * @author Acer
 */
public interface IUser {
    User getById(int userId);
    boolean add(User user);
    boolean update(User user);
}
