package com.liquidforte.song.test.grid;

import com.liquidforte.song.grid.event.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SuppressWarnings("unchecked")
public class GridEventTest extends AbstractGridTest {
    @Mock
    private GridListener<TestPoint, TestSize, String> listener;
    @Mock
    private GridAddListener<TestPoint, TestSize, String> addListener;
    @Mock
    private GridPointListener<TestPoint, TestSize, String> pointListener;
    @Mock
    private GridRemoveListener<TestPoint, TestSize, String> removeListener;
    @Mock
    private GridUpdateListener<TestPoint, TestSize, String> updateListener;

    private TestGrid grid;

    @BeforeEach
    public void setUp() {
        grid = new TestGrid(1);
    }

    @Test
    public void testAddEvent() {
        grid.addGridListener(listener);
        grid.addGridPointListener(pointListener);
        grid.addGridAddListener(addListener);

        when(listener.filterEvent(any(GridAddEvent.class))).thenReturn(true);
        when(pointListener.filterPointEvent(any(GridAddEvent.class))).thenReturn(true);
        when(addListener.filterAddEvent(any(GridAddEvent.class))).thenReturn(true);

        grid.put(new TestPoint(0), "Test");

        verifyAdd();
        verifyDone();
    }

    private void verifyAdd() {
        verify(listener, times(1)).filterEvent(any(GridAddEvent.class));
        verify(listener, times(1)).handleEvent(any(GridAddEvent.class));
        verify(pointListener, times(1)).filterPointEvent(any(GridAddEvent.class));
        verify(pointListener, times(1)).handlePointEvent(any(GridAddEvent.class));
        verify(addListener, times(1)).filterAddEvent(any(GridAddEvent.class));
        verify(addListener, times(1)).handleAddEvent(any(GridAddEvent.class));
    }

    private void verifyDone() {
        verifyNoMoreInteractions(listener, pointListener, addListener, removeListener, updateListener);
    }
}
