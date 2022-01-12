package com.github.AdamczykK.order;

import com.github.AdamczykK.order.Order;
import com.github.AdamczykK.order.OrderBackup;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecutionOrderTest {
    @Test
    void callingBackupWithoutCreatingFileFirstShouldThrowException() throws IOException {
        //given
        OrderBackup backup = new OrderBackup();
        //then
        assertThrows(IOException.class, () -> backup.backupOrder(new Order()));
    }

}
