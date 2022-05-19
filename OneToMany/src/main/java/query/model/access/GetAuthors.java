/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package query.model.access;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author marian
 */
public interface GetAuthors {

    Collection<? extends GetPosts> getAuthors();
}
