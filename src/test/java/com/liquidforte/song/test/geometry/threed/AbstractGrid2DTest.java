package com.liquidforte.song.test.geometry.threed;

import com.liquidforte.song.geometry.twod.AbstractGrid2D;
import com.liquidforte.song.gridevent.twod.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SuppressWarnings("unchecked")
public class AbstractGrid2DTest {
    @Mock
    private Grid2DListener<TestGrid, Object> listener;
    @Mock
    private Grid2DAddListener<TestGrid, Object> addListener;
    @Mock
    private Grid2DPointListener<TestGrid, Object> pointListener;
    @Mock
    private Grid2DRemoveListener<TestGrid, Object> removeListener;
    @Mock
    private Grid2DUpdateListener<TestGrid, Object> updateListener;

    private TestGrid grid;

    @BeforeEach
    public void setUp() {
        grid = new TestGrid(1, 1);
    }

    @Test
    public void testAddEvent() {
        grid.addGridListener(Grid2DListener.class, listener);
        grid.addGridListener(Grid2DPointListener.class, pointListener);
        grid.addGridListener(Grid2DAddListener.class, addListener);

        when(listener.filterEvent(any(Grid2DAddEvent.class))).thenReturn(true);
        when(pointListener.filterPointEvent(any(Grid2DAddEvent.class))).thenReturn(true);
        when(addListener.filterAddEvent(any(Grid2DAddEvent.class))).thenReturn(true);

        grid.put(0, 0, "Test");

        verifyAdd();
        verifyDone();
    }

    @Test
    public void testRemoveEvent() {
        grid.put(0, 0, "Test");

        grid.addGridListener(Grid2DListener.class, listener);
        grid.addGridListener(Grid2DPointListener.class, pointListener);
        grid.addGridListener(Grid2DRemoveListener.class, removeListener);
        grid.addGridListener(Grid2DUpdateListener.class, updateListener);

        when(listener.filterEvent(any(Grid2DEvent.class))).thenReturn(true);
        when(pointListener.filterPointEvent(any(Grid2DPointEvent.class))).thenReturn(true);
        when(removeListener.filterRemoveEvent(any(Grid2DRemoveEvent.class))).thenReturn(true);
        when(updateListener.filterUpdateEvent(any(Grid2DUpdateEvent.class))).thenReturn(true);

        grid.put(0, 0, null);

        verifyRemove();
        verifyUpdate();
        verifyDone();
    }

    private void verifyAdd() {
        verify(listener, times(1)).filterEvent(any(Grid2DAddEvent.class));
        verify(listener, times(1)).handleEvent(any(Grid2DAddEvent.class));
        verify(pointListener, times(1)).filterPointEvent(any(Grid2DAddEvent.class));
        verify(pointListener, times(1)).handlePointEvent(any(Grid2DAddEvent.class));
        verify(addListener, times(1)).filterAddEvent(any(Grid2DAddEvent.class));
        verify(addListener, times(1)).handleAddEvent(any(Grid2DAddEvent.class));
    }

    private void verifyRemove() {
        verify(listener, times(1)).filterEvent(any(Grid2DRemoveEvent.class));
        verify(listener, times(1)).handleEvent(any(Grid2DRemoveEvent.class));
        verify(pointListener, times(1)).filterPointEvent(any(Grid2DRemoveEvent.class));
        verify(pointListener, times(1)).handlePointEvent(any(Grid2DRemoveEvent.class));
        verify(removeListener, times(1)).filterRemoveEvent(any(Grid2DRemoveEvent.class));
        verify(removeListener, times(1)).handleRemoveEvent(any(Grid2DRemoveEvent.class));
    }

    private void verifyUpdate() {
        verify(listener, times(1)).filterEvent(any(Grid2DUpdateEvent.class));
        verify(listener, times(1)).handleEvent(any(Grid2DUpdateEvent.class));

        verify(pointListener, times(1)).filterPointEvent(any(Grid2DUpdateEvent.class));
        verify(pointListener, times(1)).handlePointEvent(any(Grid2DUpdateEvent.class));

        verify(updateListener, times(1)).filterUpdateEvent(any(Grid2DUpdateEvent.class));
        verify(updateListener, times(1)).handleUpdateEvent(any(Grid2DUpdateEvent.class));
    }

    private void verifyDone() {
        verifyNoMoreInteractions(listener, addListener, pointListener, removeListener, updateListener);
    }

    @Test
    public void testUpdateEvent() {
        grid.put(0, 0, "Test");

        grid.addGridListener(Grid2DListener.class, listener);
        grid.addGridListener(Grid2DPointListener.class, pointListener);
        grid.addGridListener(Grid2DAddListener.class, addListener);
        grid.addGridListener(Grid2DUpdateListener.class, updateListener);
        grid.addGridListener(Grid2DRemoveListener.class, removeListener);

        when(listener.filterEvent(any(Grid2DEvent.class))).thenReturn(true);
        when(pointListener.filterPointEvent(any(Grid2DPointEvent.class))).thenReturn(true);
        when(addListener.filterAddEvent(any(Grid2DAddEvent.class))).thenReturn(true);
        when(removeListener.filterRemoveEvent(any(Grid2DRemoveEvent.class))).thenReturn(true);
        when(updateListener.filterUpdateEvent(any(Grid2DUpdateEvent.class))).thenReturn(true);

        grid.put(0, 0, "Test 2");

        verifyRemove();
        verifyAdd();
        verifyUpdate();
        verifyDone();
    }

    private static class TestGrid extends AbstractGrid2D<TestGrid, Object> {
        private final Object[][] grid;

        public TestGrid(int w, int h) {
            this.grid = new Object[w][h];
        }

        @Override
        protected Object doGet(int x, int y) {
            return grid[x][y];
        }

        @Override
        protected Object doPut(int x, int y, Object o) {
            Object old = grid[x][y];
            grid[x][y] = o;
            return old;
        }

        @Override
        public int getWidth() {
            return grid.length;
        }

        @Override
        public int getHeight() {
            return grid[0].length;
        }
    }
}
