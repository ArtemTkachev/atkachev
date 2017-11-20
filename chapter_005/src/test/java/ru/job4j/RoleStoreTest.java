package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RoleStoreTest {
    private RoleStore roleStore;

    @Before
    public void setUp() {
        roleStore = new RoleStore(100);
    }

    @Test
    public void whenAddRoleThenRoleStoreHasRoleAndReturnRole() {
        Role role = new Role("0001");
        Role returnRole = (Role) roleStore.add(role);
        assertThat(returnRole,is(role));
    }

    @Test
    public void whenUpdateRoleThenRoleStoreHasUpdateRoleAndReturnOldRole() {
        Role role = new Role("0001");
        Role addRole = (Role) roleStore.add(role);
        Role role2 = new Role("0001");
        Role returnRole = (Role) roleStore.update(role2);
        assertThat(returnRole,is(role));
    }

    @Test
    public void whenDeleteRoleWithIdThenRoleStoreHasNotRoleWhithSameIdAndReturnTrue() {
        Role role = new Role("0001");
        Role addRole = (Role) roleStore.add(role);
        boolean result = roleStore.delete("0001");
        assertThat(result,is(true));
    }

}
