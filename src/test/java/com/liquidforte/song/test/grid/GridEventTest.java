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
        grid.addGridListener(listener);
        grid.addGridPointListener(pointListener);
        grid.addGridAddListener(addListener);
        grid.addGridRemoveListener(removeListener);
        grid.addGridUpdateListener(updateListener);
    }

    @Test
    public void testAddEvent() {
        when(listener.filterEvent(any(GridAddEvent.class))).thenReturn(true);
        when(pointListener.filterPointEvent(any(GridAddEvent.class))).thenReturn(true);
        when(addListener.filterAddEvent(any(GridAddEvent.class))).thenReturn(true);

        grid.put(new TestPoint(0), "Test");
        grid.put(new TestPoint(0), "Test");

        verifyAdd();
        verifyDone();
    }

    @Test
    public void testRemoveEvent() {
        when(listener.filterEvent(any(GridAddEvent.class))).thenReturn(false);
        when(listener.filterEvent(any(GridRemoveEvent.class))).thenReturn(true);
        when(pointListener.filterPointEvent(any(GridAddEvent.class))).thenReturn(false);
        when(pointListener.filterPointEvent(any(GridRemoveEvent.class))).thenReturn(true);
        when(addListener.filterAddEvent(any(GridAddEvent.class))).thenReturn(false);
        when(removeListener.filterRemoveEvent(any(GridRemoveEvent.class))).thenReturn(true);

        grid.put(new TestPoint(0), "Test");
        grid.put(new TestPoint(0), "Test");
        grid.put(new TestPoint(0), null);

        verifyRemove();
        verifyDone();
    }

    @Test
    public void testUpdateEvent() {
        when(listener.filterEvent(any(GridAddEvent.class))).thenReturn(false);
        when(listener.filterEvent(any(GridRemoveEvent.class))).thenReturn(false);
        when(listener.filterEvent(any(GridUpdateEvent.class))).thenReturn(true);

        when(pointListener.filterPointEvent(any(GridAddEvent.class))).thenReturn(false);
        when(pointListener.filterPointEvent(any(GridRemoveEvent.class))).thenReturn(false);
        when(pointListener.filterPointEvent(any(GridUpdateEvent.class))).thenReturn(true);

        when(addListener.filterAddEvent(any(GridAddEvent.class))).thenReturn(false);
        when(addListener.filterAddEvent(any(GridUpdateEvent.class))).thenReturn(true);

        when(removeListener.filterRemoveEvent(any(GridRemoveEvent.class))).thenReturn(false);
        when(removeListener.filterRemoveEvent(any(GridUpdateEvent.class))).thenReturn(true);

        when(updateListener.filterUpdateEvent(any(GridUpdateEvent.class))).thenReturn(true);

        grid.put(new TestPoint(0), null);
        grid.put(new TestPoint(0), "Test");
        grid.put(new TestPoint(0), null);
        grid.put(new TestPoint(0), "Test");
        grid.put(new TestPoint(0), "Test 2");
        grid.put(new TestPoint(0), null);

        verifyUpdate();
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

    private void verifyRemove() {
        verify(listener, times(1)).filterEvent(any(GridAddEvent.class));
        verify(pointListener, times(1)).filterPointEvent(any(GridAddEvent.class));
        verify(addListener, times(1)).filterAddEvent(any(GridAddEvent.class));

        verify(listener, times(1)).filterEvent(any(GridRemoveEvent.class));
        verify(listener, times(1)).handleEvent(any(GridRemoveEvent.class));
        verify(pointListener, times(1)).filterPointEvent(any(GridRemoveEvent.class));
        verify(pointListener, times(1)).handlePointEvent(any(GridRemoveEvent.class));
        verify(removeListener, times(1)).filterRemoveEvent(any(GridRemoveEvent.class));
        verify(removeListener, times(1)).handleRemoveEvent(any(GridRemoveEvent.class));
    }

    private void verifyUpdate() {
        verify(listener, times(4)).filterEvent(any(GridAddEvent.class));
        verify(listener, times(2)).filterEvent(any(GridUpdateEvent.class));
        verify(listener, times(2)).handleEvent(any(GridUpdateEvent.class));

        verify(pointListener, times(4)).filterPointEvent(any(GridAddEvent.class));
        verify(pointListener, times(2)).filterPointEvent(any(GridUpdateEvent.class));
        verify(pointListener, times(2)).handlePointEvent(any(GridUpdateEvent.class));

        verify(addListener, times(3)).filterAddEvent(any(GridAddEvent.class));
        verify(addListener, times(1)).handleAddEvent(any(GridUpdateEvent.class));

        verify(removeListener, times(1)).filterRemoveEvent(any(GridUpdateEvent.class));
        verify(removeListener, times(1)).handleRemoveEvent(any(GridUpdateEvent.class));

        verify(updateListener, times(1)).filterUpdateEvent(any(GridUpdateEvent.class));
        verify(updateListener, times(1)).handleUpdateEvent(any(GridUpdateEvent.class));
    }

    private void verifyDone() {
        verifyNoMoreInteractions(listener, pointListener, addListener, removeListener, updateListener);
    }
}
