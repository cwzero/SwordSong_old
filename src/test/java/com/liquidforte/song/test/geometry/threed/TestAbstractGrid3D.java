package com.liquidforte.song.test.geometry.threed;

import com.liquidforte.song.geometry.threed.AbstractGrid3D;
import com.liquidforte.song.gridevent.threed.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SuppressWarnings("unchecked")
public class TestAbstractGrid3D {
    @Mock
    private Grid3DListener<TestGrid, Object> listener;
    @Mock
    private Grid3DAddListener<TestGrid, Object> addListener;
    @Mock
    private Grid3DPointListener<TestGrid, Object> pointListener;
    @Mock
    private Grid3DRemoveListener<TestGrid, Object> removeListener;
    @Mock
    private Grid3DUpdateListener<TestGrid, Object> updateListener;

    private TestGrid grid;

    @BeforeEach
    public void setUp() {
        grid = new TestGrid(1, 1, 1);
    }

    @Test
    public void testAddEvent() {
        grid.addGridListener(Grid3DListener.class, listener);
        grid.addGridListener(Grid3DPointListener.class, pointListener);
        grid.addGridListener(Grid3DAddListener.class, addListener);

        when(listener.filterEvent(any(Grid3DAddEvent.class))).thenReturn(true);
        when(pointListener.filterPointEvent(any(Grid3DAddEvent.class))).thenReturn(true);
        when(addListener.filterAddEvent(any(Grid3DAddEvent.class))).thenReturn(true);

        grid.put(0, 0, 0, "Test");

        verifyAdd();
        verifyDone();
    }

    @Test
    public void testRemoveEvent() {
        grid.put(0, 0, 0, "Test");

        grid.addGridListener(Grid3DListener.class, listener);
        grid.addGridListener(Grid3DPointListener.class, pointListener);
        grid.addGridListener(Grid3DRemoveListener.class, removeListener);
        grid.addGridListener(Grid3DUpdateListener.class, updateListener);

        when(listener.filterEvent(any(Grid3DEvent.class))).thenReturn(true);
        when(pointListener.filterPointEvent(any(Grid3DPointEvent.class))).thenReturn(true);
        when(removeListener.filterRemoveEvent(any(Grid3DRemoveEvent.class))).thenReturn(true);
        when(updateListener.filterUpdateEvent(any(Grid3DUpdateEvent.class))).thenReturn(true);

        grid.put(0, 0, 0, null);

        verifyRemove();
        verifyUpdate();
        verifyDone();
    }

    private void verifyAdd() {
        verify(listener, times(1)).filterEvent(any(Grid3DAddEvent.class));
        verify(listener, times(1)).handleEvent(any(Grid3DAddEvent.class));
        verify(pointListener, times(1)).filterPointEvent(any(Grid3DAddEvent.class));
        verify(pointListener, times(1)).handlePointEvent(any(Grid3DAddEvent.class));
        verify(addListener, times(1)).filterAddEvent(any(Grid3DAddEvent.class));
        verify(addListener, times(1)).handleAddEvent(any(Grid3DAddEvent.class));
    }

    private void verifyRemove() {
        verify(listener, times(1)).filterEvent(any(Grid3DRemoveEvent.class));
        verify(listener, times(1)).handleEvent(any(Grid3DRemoveEvent.class));
        verify(pointListener, times(1)).filterPointEvent(any(Grid3DRemoveEvent.class));
        verify(pointListener, times(1)).handlePointEvent(any(Grid3DRemoveEvent.class));
        verify(removeListener, times(1)).filterRemoveEvent(any(Grid3DRemoveEvent.class));
        verify(removeListener, times(1)).handleRemoveEvent(any(Grid3DRemoveEvent.class));
    }

    private void verifyUpdate() {
        verify(listener, times(1)).filterEvent(any(Grid3DUpdateEvent.class));
        verify(listener, times(1)).handleEvent(any(Grid3DUpdateEvent.class));

        verify(pointListener, times(1)).filterPointEvent(any(Grid3DUpdateEvent.class));
        verify(pointListener, times(1)).handlePointEvent(any(Grid3DUpdateEvent.class));

        verify(updateListener, times(1)).filterUpdateEvent(any(Grid3DUpdateEvent.class));
        verify(updateListener, times(1)).handleUpdateEvent(any(Grid3DUpdateEvent.class));
    }

    private void verifyDone() {
        verifyNoMoreInteractions(listener, addListener, pointListener, removeListener, updateListener);
    }

    @Test
    public void testUpdateEvent() {
        grid.put(0, 0, 0, "Test");

        grid.addGridListener(Grid3DListener.class, listener);
        grid.addGridListener(Grid3DPointListener.class, pointListener);
        grid.addGridListener(Grid3DAddListener.class, addListener);
        grid.addGridListener(Grid3DUpdateListener.class, updateListener);
        grid.addGridListener(Grid3DRemoveListener.class, removeListener);

        when(listener.filterEvent(any(Grid3DEvent.class))).thenReturn(true);
        when(pointListener.filterPointEvent(any(Grid3DPointEvent.class))).thenReturn(true);
        when(addListener.filterAddEvent(any(Grid3DAddEvent.class))).thenReturn(true);
        when(removeListener.filterRemoveEvent(any(Grid3DRemoveEvent.class))).thenReturn(true);
        when(updateListener.filterUpdateEvent(any(Grid3DUpdateEvent.class))).thenReturn(true);

        grid.put(0, 0, 0, "Test 2");

        verifyRemove();
        verifyAdd();
        verifyUpdate();
        verifyDone();
    }

    private static class TestGrid extends AbstractGrid3D<TestGrid, Object> {
        private final Object[][][] grid;

        public TestGrid(int w, int h, int d) {
            this.grid = new Object[w][h][d];
        }

        @Override
        protected Object doGet(int x, int y, int z) {
            return grid[x][y][z];
        }

        @Override
        protected Object doPut(int x, int y, int z, Object o) {
            Object old = grid[x][y][z];
            grid[x][y][z] = o;
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

        @Override
        public int getDepth() {
            return grid[0][0].length;
        }
    }
}
